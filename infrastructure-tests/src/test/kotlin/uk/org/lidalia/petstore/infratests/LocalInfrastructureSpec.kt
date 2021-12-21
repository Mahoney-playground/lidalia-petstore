package uk.org.lidalia.petstore.infratests

import io.kotest.core.spec.style.StringSpec

class LocalInfrastructureSpec : StringSpec({
  include(infrastructureSpec(environmentDescriptor = local))
})
