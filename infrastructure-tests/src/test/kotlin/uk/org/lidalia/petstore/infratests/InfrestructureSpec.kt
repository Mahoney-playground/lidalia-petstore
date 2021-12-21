package uk.org.lidalia.petstore.infratests

import io.kotest.core.spec.style.stringSpec
import io.kotest.matchers.result.shouldBeSuccess

internal fun infrastructureSpec(
  environmentDescriptor: EnvironmentDescriptor
) = stringSpec {

  "${environmentDescriptor.uiUrl} returns the UI" {

    // given
    val environment = environmentDescriptor.deploy()

    // expect
    environment.shouldBeSuccess()

    // when
    val ui = environment.getOrThrow().requestUi()

    // then
    ui.shouldBeSuccess()
  }
}
