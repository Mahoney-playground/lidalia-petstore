package uk.org.lidalia.petstore.infratests

import java.net.URI

data class EnvironmentDescriptor(
  val uiUrl: URI,
  private val deploymentStrategy: DeploymentStrategy
) {
  fun deploy(): Result<Environment> = deploymentStrategy.invoke().map {
    Environment()
  }
}

class Environment {
  fun requestUi(): Result<Ui> { TODO() }
}

interface Ui

@JvmInline
value class Domain(private val value: String) {
  override fun toString() = value
}

fun environment(
  publicSuffix: Domain,
  deploymentStrategy: DeploymentStrategy,
) = EnvironmentDescriptor(
  uiUrl = URI.create("https://petshop.lidalia.$publicSuffix"),
  deploymentStrategy = deploymentStrategy,
)

val localhost = Domain("localhost")
val local = environment(
  publicSuffix = localhost,
  deploymentStrategy = DockerComposeDeploymentStrategy(),
)
