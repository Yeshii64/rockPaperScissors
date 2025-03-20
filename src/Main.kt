import kotlin.system.exitProcess

//Rock Paper Scissors game!
//March 12
//TODO (ideas! - make it so that the user is able to play multiple rounds, win loss ratio??
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
fun gameplay(): List<Int> {
    var playerScore = 0
    var computerScore = 0
    val WinList = mutableListOf<Int>()
    val LossList = mutableListOf<Int>()
    println("Pick your choice (rock, paper, or scissors): ")
    val playerChoice = readlnOrNull()?.lowercase() ?: ""


    if (playerChoice.isBlank() || playerChoice.toIntOrNull() != null) {
        println("Invalid input")
        menu()
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

        //computer wins
        if(playerChoice == "rock" && randomchoice == "paper"){
            println("Computer gains a point!")
            computerScore++
            //adding the loss or win (refer to line 75) to a list so the user can see how many wins/losses they have
            LossList.add(1, computerScore)
        }else if (playerChoice == "paper" && randomchoice == "scissors"){
            println("Computer gains a point!")
            computerScore++
            LossList.add(1, computerScore)
        }else if (playerChoice == "scissors" && randomchoice == "rock"){
            println("Computer gains a point!")
            computerScore++
            LossList.add(1, computerScore)
        }
        //player wins
        if (randomchoice == "rock" && playerChoice == "paper"){
            println("Player gains a point!")
            playerScore++
            WinList.add(1, playerScore)
        } else if(randomchoice == "paper" && playerChoice == "scissors"){
            println("Player gains a point!")
            playerScore++
            WinList.add(1, playerScore)
        } else if(randomchoice == "scissors" && playerChoice == "rock"){
            println("Player gains a point!")
            playerScore++
            WinList.add(1, playerScore)
        }

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
    println("1. Win/Loss Count")
    println("2. Win/Loss Ratio")
    println("3. Tie Count")
    println("What do you want to view?")

    when(readlnOrNull()?.toIntOrNull()){
        1 -> WLCOUNT()
    }

}

//viewing win loss count
fun WLCOUNT(WinList: List<Int>, LossList: List<Int>){
    println("You have ${WinList.size} wins and ${LossList.size} losses.")
}




//exiting the function
fun exit(){
    println("Closing the program!")
    exitProcess(1)
}




