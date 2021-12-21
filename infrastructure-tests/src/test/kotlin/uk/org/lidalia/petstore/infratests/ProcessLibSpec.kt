package uk.org.lidalia.petstore.infratests

// import com.lordcodes.turtle.shellRun
import dorkbox.executor.Executor
import dorkbox.executor.exceptions.InvalidExitValueException
// import eu.jrie.jetbrains.kotlinshell.shell.shell
import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.StringSpec
import kotlinx.coroutines.ExperimentalCoroutinesApi

@ExperimentalCoroutinesApi
class ProcessLibSpec : StringSpec({

//  "turtle fails if a command fails" {
//    shouldThrow<Exception> {
//      val x = shellRun {
//        command("false")
//        val y = command("echo", listOf("hello"))
//        command("echo", listOf(y, "world"))
//      }
//      println(x)
//      shellRun("false")
//    }
//  }

//  "kotlin shell fails if a command fails" {
//    shouldThrow<Exception> {
//      shell {
//        pipeline { "false".process() pipe "grep abc".process() pipe "echo hello world".process() }
//      }
//    }
//  }

  "executor fails if a command fails" {
    val e = shouldThrow<InvalidExitValueException> {
      Executor().command("false").exitValueNormal().start().output.string()
    }
    e.printStackTrace()
  }
  "executor can pipe" {
    Executor().command("echo", "hello world").exitValueNormal()
      .start().output.string()
  }
})
