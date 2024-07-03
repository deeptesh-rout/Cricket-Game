import java.util.*

fun main() {
    val ha = Scanner(System.`in`)
    val random = Random()
    var userBatting: Int
    var userBowling: Int

    var userWicket = 0
    var systemWicket = 0
    println("Ladies and Gentlemen, a great match between the user and the system. Let's see who will win the match")
    println("How many overs do you want to play?")
    val over = ha.nextInt()
    println("Total 5 wickets in each team")
    println("It's toss time. What is your call?")
    println("Head (0), Tail (1): ")
    val user = ha.nextInt()

    val computerToss = random.nextInt(2)
    var systemScore = 0
    var userScore = 0
    if (computerToss == user) {
        println("Congratulations, you won the toss")
        println("What do you want to choose, batting or bowling first? [(1): bat or (2): ball]")
        val option = ha.nextInt()

        if (option == 1) {
            println("You chose batting first (System will bowl to you)")
            println("Enter 1: One run, 2: Two runs, 3: Three runs, 4: Four runs, 5: Five runs, 6: Six runs")

            for (i in 1..over) {
                for (j in 1..6) {
                    print("Bat:")
                    userBatting = ha.nextInt()
                    val computerBowling = (Math.random() * 6).toInt() + 1
                    if (userBatting != computerBowling) {
                        println("You hit: $userBatting runs, System chose: $computerBowling")
                        userScore += userBatting
                    } else if (userBatting == computerBowling) {
                        userWicket++
                        println("Oops, you're out because your choice and the computer's choice are the same. You: $userBatting, System chose: $computerBowling")
                    }
                    if (userWicket == 5) break
                    if (j == 6) {
                        when {
                            i > 1 && userWicket > 1 -> println("After completing $i overs, the score is $userScore runs with the loss of $userWicket wickets")
                            i > 1 && userWicket < 1 -> println("After completing $i over, the score is $userScore runs with the loss of $userWicket wicket")
                            i == 1 && userWicket > 1 -> println("After completing $i over, the score is $userScore runs with the loss of $userWicket wickets")
                            i == 1 && userWicket < 1 -> println("After completing $i over, the score is $userScore runs with the loss of $userWicket wickets")
                        }
                    }
                }
            }
            println("Total score: $userScore")
            println("2nd innings start in a few sec, \"now it your turn to bowling and defend your Score\" (Target): ${userScore + 1}\nchoose same number as system choose for taking wicket")
            for (m in 1..over) {
                for (n in 1..6) {
                    print("Ball:")
                    userBowling = ha.nextInt()
                    val computerBatting = (Math.random() * 6).toInt() + 1

                    if (userBowling != computerBatting) {
                        println("System hit: $computerBatting runs, You chose: $userBowling")
                        systemScore += computerBatting
                    }
                    if (userBowling == computerBatting) {
                        systemWicket++
                        println("Yes, you got it, $systemWicket wickets gone of System because your choice and the computer's choice are the same. You: $userBowling, System chose: $computerBatting")
                    }
                    if (systemWicket == 5) break
                    if (n == 6) {
                        when {
                            m > 1 && systemWicket > 1 -> println("After completing $m overs, the score is $systemScore runs with the loss of $systemWicket wickets")
                            m > 1 && systemWicket < 1 -> println("After completing $m over, the score is $systemScore runs with the loss of $systemWicket wicket")
                            m == 1 && systemWicket > 1 -> println("After completing $m over, the score is $systemScore runs with the loss of $systemWicket wickets")
                            m == 1 && systemWicket < 1 -> println("After completing $m over, the score is $systemScore runs with the loss of $systemWicket wickets")
                        }
                    }
                }
            }
            when {
                userScore > systemScore -> println("Congratulations, you won the game by: ${userScore - systemScore} runs")
                userScore < systemScore -> println("Oo you lose the game by: ${5 - systemWicket} wickets, but nice try. Best of Luck for the next game")
                userScore == systemScore -> println("Oo it is a tie score between You and the System $userScore - $systemScore runs, Well played")
            }
        }
        if (option == 2) {
            println("You chose bowling first (System will bat first...) \nchoose the same number as the system chooses for taking wickets")
            println("Enter 1: One run, 2: Two runs, 3: Three runs, 4: Four runs, 5: Five runs, 6: Six runs")

            for (i in 1..over) {
                for (j in 1..6) {
                    print("Ball:")
                    userBowling = ha.nextInt()
                    val computerBatting = (Math.random() * 6).toInt() + 1

                    if (userBowling != computerBatting) {
                        println("System hit: $computerBatting runs, You chose: $userBowling")
                        systemScore += computerBatting
                    }
                    if (userBowling == computerBatting) {
                        systemWicket++
                        println("Yes, you got it, $systemWicket wickets gone of System because your choice and the computer's choice are the same. You: $userBowling, System chose: $computerBatting")
                    }
                    if (systemWicket == 5) break
                    if (j == 6) {
                        when {
                            i > 1 && systemWicket > 1 -> println("After completing $i overs, the score is $systemScore runs with the loss of $systemWicket wickets")
                            i > 1 && systemWicket < 1 -> println("After completing $i over, the score is $systemScore runs with the loss of $systemWicket wicket")
                            i == 1 && systemWicket > 1 -> println("After completing $i over, the score is $systemScore runs with the loss of $systemWicket wickets")
                            i == 1 && systemWicket < 1 -> println("After completing $i over, the score is $systemScore runs with the loss of $systemWicket wickets")
                        }
                    }
                }
            }

            println("Total score: $systemScore")
            println("2nd innings start in a few sec, \"now it your turn to bat and chase the Score\" (Target): ${userScore + 1}")
            for (m in 1..over) {
                for (n in 1..6) {
                    print("Bat:")
                    userBatting = ha.nextInt()
                    val computerBowling = (Math.random() * 6).toInt() + 1
                    if (userBatting != computerBowling) {
                        println("You hit: $userBatting runs, System chose: $computerBowling")
                        userScore += userBatting
                    } else if (userBatting == computerBowling) {
                        userWicket++
                        println("Oops, you're out because your choice and the computer's choice are the same. You: $userBatting, System chose: $computerBowling")
                    }
                    if (userWicket == 5) break
                    if (n == 6) {
                        when {
                            n > 1 && userWicket > 1 -> println("After completing $m overs, the score is $userScore runs with the loss of $userWicket wickets")
                            n > 1 && userWicket < 1 -> println("After completing $m over, the score is $userScore runs with the loss of $userWicket wicket")
                            n == 1 && userWicket > 1 -> println("After completing $m over, the score is $userScore runs with the loss of $userWicket wickets")
                            n == 1 && userWicket < 1 -> println("After completing $m over, the score is $userScore runs with the loss of $userWicket wickets")
                        }
                    }
                }
            }
            when {
                userScore > systemScore -> println("Congratulations, you won the game by: ${5 - systemWicket} wickets")
                userScore < systemScore -> println("You lose the game by: ${systemScore - userScore} runs, but nice try. Best of Luck for the next game")
                userScore == systemScore -> println("Oo it is a tie score between You and the System $userScore - $systemScore runs, Well played")
            }
        }
    } else {
        println("System won the toss and chose batting first")
        println("System batting first (you have to bowl first...) \nchoose the same number as the system chooses for taking wickets")
        println("Enter 1: One run, 2: Two runs, 3: Three runs, 4: Four runs, 5: Five runs, 6: Six runs")

        for (i in 1..over) {
            for (j in 1..6) {
                print("Ball:")
                userBowling = ha.nextInt()
                val computerBatting = (Math.random() * 6).toInt() + 1

                if (userBowling != computerBatting) {
                    println("System hit: $computerBatting runs, You chose: $userBowling")
                    systemScore += computerBatting
                }
                if (userBowling == computerBatting) {
                    systemWicket++
                    println("Yes, you got it, $systemWicket wickets gone of System because your choice and the computer's choice are the same. You: $userBowling, System chose: $computerBatting")
                }
                if (systemWicket == 5) break
                if (j == 6) {
                    when {
                        i > 1 && systemWicket > 1 -> println("After completing $i overs, the score is $systemScore runs with the loss of $systemWicket wickets")
                        i > 1 && systemWicket < 1 -> println("After completing $i over, the score is $systemScore runs with the loss of $systemWicket wicket")
                        i == 1 && systemWicket > 1 -> println("After completing $i over, the score is $systemScore runs with the loss of $systemWicket wickets")
                        i == 1 && systemWicket < 1 -> println("After completing $i over, the score is $systemScore runs with the loss of $systemWicket wickets")
                    }
                }
            }
        }

        println("Total score: $systemScore")
        println("2nd innings start in a few sec, \"now it your turn to bat and chase the Score\" (Target): ${userScore + 1}")
        for (m in 1..over) {
            for (n in 1..6) {
                print("Bat:")
                userBatting = ha.nextInt()
                val computerBowling = (Math.random() * 6).toInt() + 1
                if (userBatting != computerBowling) {
                    println("You hit: $userBatting runs, System chose: $computerBowling")
                    userScore += userBatting
                } else if (userBatting == computerBowling) {
                    userWicket++
                    println("Oops, you're out because your choice and the computer's choice are the same. You: $userBatting, System chose: $computerBowling")
                }
                if (userWicket == 5) break
                if (n == 6) {
                    when {
                        n > 1 && userWicket > 1 -> println("After completing $m overs, the score is $userScore runs with the loss of $userWicket wickets")
                        n > 1 && userWicket < 1 -> println("After completing $m over, the score is $userScore runs with the loss of $userWicket wicket")
                        n == 1 && userWicket > 1 -> println("After completing $m over, the score is $userScore runs with the loss of $userWicket wickets")
                        n == 1 && userWicket < 1 -> println("After completing $m over, the score is $userScore runs with the loss of $userWicket wickets")
                    }
                }
            }
        }
        when {
            userScore > systemScore -> println("Congratulations, you won the game by: ${5 - systemWicket} wickets")
            userScore < systemScore -> println("You lose the game by: ${systemScore - userScore} runs, but nice try. Best of Luck for the next game")
            userScore == systemScore -> println("Oo it is a tie score between You and the System $userScore - $systemScore runs, Well played")
        }
    }
}
