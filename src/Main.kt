import kotlin.system.exitProcess

//Rock Paper Scissors game!
//March 12


val WinList = mutableListOf<Int>()
val LossList = mutableListOf<Int>()
val tieList = mutableListOf<Int>()

fun main() {
        menu()
}


//code for the menu
fun menu(){
    println("Hi Welcome!")
    println("1. Play Rock, Paper, Scissors")
    println("2. Stats")
    println("3. Exit")
    println("Choose:")

    when(readlnOrNull()?.toIntOrNull()){
        1 -> gameplay()
        2 -> statMenu()
        3 -> exit()
        else -> println("Invalid.")
    }
}

//code for the gameplay
fun gameplay(): Int {
    var playerScore = 0
    var computerScore = 0
    var tietimes = 0
    val validInputs = arrayOf("rock", "paper", "scissors") //for input validation
    println("Pick your choice (rock, paper, or scissors): ")
    val playerChoice = readlnOrNull()?.lowercase() ?: ""


    if(playerChoice in validInputs){
        val choices = arrayOf("rock", "paper", "scissors")
        var randomchoice = choices.random()
        println(randomchoice)

        // in case of a tie
        val tie = playerChoice == randomchoice
        if (tie){
            println("You picked the same choice!")
            println("Computer choice: $randomchoice")
            println("Player choice: $playerChoice")
            tietimes++
            tieList.add(tietimes)
        }
        //computer wins
        if(playerChoice == "rock" && randomchoice == "paper"){
            println("Computer gains a point!")
            computerScore++
            //adding the loss or win (refer to line 75) to a list so the user can see how many wins/losses they have
            LossList.add(computerScore)
        }else if (playerChoice == "paper" && randomchoice == "scissors"){
            println("Computer gains a point!")
            computerScore++
            LossList.add(computerScore)
        }else if (playerChoice == "scissors" && randomchoice == "rock"){
            println("Computer gains a point!")
            computerScore++
            LossList.add(computerScore)
        }
        //player wins
        if (randomchoice == "rock" && playerChoice == "paper"){
            println("Player gains a point!")
            playerScore++
            WinList.add(playerScore)
        } else if(randomchoice == "paper" && playerChoice == "scissors"){
            println("Player gains a point!")
            playerScore++
            WinList.add(playerScore)
        } else if(randomchoice == "scissors" && playerChoice == "rock"){
            println("Player gains a point!")
            playerScore++
            WinList.add(playerScore)
        }

        //u know how games have a pause menu where they ask if you want to go to the menu and such? yeah.
        println("Do you want to go back to the menu (input 'menu') Or play again? (input 'again')")
        val yesOrNo = readlnOrNull()?.lowercase()
        if (yesOrNo == "menu") {
            menu()
        } else if (yesOrNo == "again") {
            gameplay()
        }

    } else {
        println("Invalid input")
        menu()
    }
    return playerScore
    return computerScore
}




//code for viewing the stats
fun statMenu(){
    println("1. Win/Loss Count")
    println("2. Win/Loss Ratio")
    println("3. Tie Count")
    println("4. Go back to Menu")
    println("What do you want to view?")

    when(readlnOrNull()?.toIntOrNull()){
        1 -> {
            println("You have ${WinList.size} wins and ${LossList.size} losses.")
            statMenu()
        }
        2 -> winLossRatio()
        3 -> tieCount()
        4 -> menu()
    }
}

//to calculate the win loss ratio you need to divide the wins by the losses
fun winLossRatio(){
    var wins = WinList.count().toDouble()
    var losses = LossList.count()

    if (losses != 0){
        println( wins / losses )
        statMenu()
    } else{
        println("You have no losses, cannot calculate!")
        statMenu()
    }

}

fun tieCount(){
    if(tieList.count() != 0){
        println("You and the computer have tied ${tieList.count()} of times!")
        statMenu()
    } else {
        println("You and the computer have tied 0 times.")
        statMenu()
    }
}


//exiting the function
fun exit(){
    println("Closing the program!")
    exitProcess(1)
}




