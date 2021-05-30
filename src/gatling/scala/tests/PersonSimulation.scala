package tests

import io.gatling.core.Predef._
import io.gatling.http.Predef._

import scala.concurrent.duration._
import scala.language.postfixOps

class PersonSimulation extends Simulation {

  object Update {

    val file = csv("persons.csv").random
    val scenarioUpdate = scenario("Update")
      .feed(file)
      .exec(
        http("update").put("/person").body(StringBody(""" { "id": "${id}", "name" : "${name}" } """))
      ).pause(1.seconds)

  }

  object Create {

    val file = csv("create-persons.csv").random
    val scenarioCreate = scenario("Create_New_Person")
      .feed(file)
      .exec(
        http("create").post("/person").body(StringBody((""" { "name": "${name}" } """)))
      ).pause(1.seconds)

  }

  object SearchById {

    var file = csv("ids.csv").random
    val scenarioFindById = scenario("Load_Find_By_ID")
      .feed(file)
      .exec(
        http("find_by_id").get("/person/${id}")
      ).pause(1.seconds)
  }

  object Search {

    var pagination = csv("pagination.csv").random

    val scenarioFindAll = scenario("Load_Find_All")
      .feed(pagination)
      .exec(
        http("list_persons").get("/person?page=${page}&size=${size}").check(status.in(200, 201, 202, 203, 204))
      ).pause(1.seconds)
  }

  val httpProtocol = http.baseUrl("http://localhost:8080").header("Content-Type", "application/json")

  val admins = scenario("admins").exec(Search.scenarioFindAll, SearchById.scenarioFindById, Update.scenarioUpdate, Create.scenarioCreate)
  val users = scenario("users").exec(Search.scenarioFindAll, SearchById.scenarioFindById)


  setUp(
    admins.inject(
      rampUsersPerSec(0).to(100).during(5.minutes)
    ),
    users.inject(
      rampUsersPerSec(0).to(100).during(10.minutes)
    )
  ).protocols(httpProtocol)
}
