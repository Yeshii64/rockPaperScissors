import kotlin.system.exitProcess

//Rock Paper Scissors game!
//March 12
fun main() {
        menu()
}


//code for the menu
fun menu(){
    println("worked")
    println("Hi Welcome!")
    println("1. Play Rock, Paper, Scissors")
    println("2. Difficulty Settings")
    println("3. Stats")
    println("4. Exit")
    println("Choose:")

    when(readlnOrNull()?.toIntOrNull()){
        1 -> gameplay()
        2 -> difficulty()
        3 -> viewWL()
        4 -> exit()
        else -> println("Invalid.")
    }
}

//code for the gameplay
fun gameplay() {
    println("Pick your choice: ")
    val playerChoice = readlnOrNull()?.lowercase() ?: ""


    if (playerChoice.isBlank() || playerChoice.toIntOrNull() != null) {
        println("Invalid input")
    } else {
        val choices = arrayOf("rock", "paper", "scissors")
        var randomchoice = choices.random()
        println(randomchoice)

        // in case of a tie
        val tie = playerChoice == randomchoice
        if (tie){
            println("You picked the same choice!")

            println("Computer choice: $randomchoice")
            println("Player choice: $playerChoice")
        }

        //TODO("code the actual game") - march 18 7:16
        if(playerChoice == "rock" )
        //u know how games have a pause menu where they ask if you want to go to the menu and such? yeah.
        println("Do you want to go back to the menu (input 'menu') Or play again? (input 'again')")
        val yesOrNo = readlnOrNull()?.lowercase()
        if (yesOrNo == "menu") {
            menu()
        } else if (yesOrNo == "again") {
            gameplay()
        }

    }
}

//code for difficulty settings
fun difficulty(){
    println("I am the difficulty setting")
    //TODO(difficulty setting)
}
//code for viewing the stats
fun viewWL(){
    println("View your win loss")
    //TODO(wl stats)
}
//exiting the function
fun exit(){
    println("Closing the program!")
    exitProcess(1)
}




