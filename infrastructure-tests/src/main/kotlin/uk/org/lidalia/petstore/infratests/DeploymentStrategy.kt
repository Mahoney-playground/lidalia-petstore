package uk.org.lidalia.petstore.infratests

import java.io.File

interface DeploymentStrategy {
  fun invoke(): Result<Nothing>
}

class DockerComposeDeploymentStrategy(
  private val composeFile: File = File("../docker-compose.yml")
) : DeploymentStrategy {

  override fun invoke(): Result<Nothing> {
    require(composeFile.exists()) {
      "File ${composeFile.absolutePath} must exist to do a docker compose up"
    }
    TODO()
  }
}
