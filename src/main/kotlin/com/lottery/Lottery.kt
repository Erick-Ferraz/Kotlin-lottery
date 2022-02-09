package com.lottery

import java.lang.NumberFormatException
import java.util.*
import kotlin.collections.ArrayList

fun main() {
    generatePrize()
}

fun generatePrize() {
    val winningNumbers: ArrayList<Int> = ArrayList<Int>()
    val random = Random()

    for (int in 1..6) {
        while(true) {
            val winningNumber = random.nextInt(60) + 1
            if (!winningNumbers.contains(winningNumber)) {
                winningNumbers.add(winningNumber)
                break
            }
        }
    }
    runLottery(winningNumbers)
}

fun runLottery(winningNumbers: List<Int>) {
    val inputNumbers: ArrayList<Int> = ArrayList<Int>()

    println("\nAposte na maior loteria dos devs: o Mega Kotlin da Virada!")
    println("\nAs regras:\n- Escolha 6 números diferentes, entre 1 e 60")
    println("- Informe cada número individualmente")

    for (int in 1..6) {
        while (true) {
            println("\nSeus números até o momento: $inputNumbers")
            println("Informe o $int número (1-60): ")
            try {
                val inputNumber = readLine()
                when (val number = Integer.parseInt(inputNumber)) {
                    in (1..60) -> {
                        inputNumbers.add(number)
                        break
                    }
                    else -> println("$number não é um número entre 1 e 60. Tente novamente.")
                }
            }catch (nfe: NumberFormatException) {
                println("Informe um valor numérico válido! Tente novamente.")
            }
        }
    }

    println("\nOs números vencedores foram: $winningNumbers")
    println("\nOs seus números escolhidos: $inputNumbers")

    inputNumbers.retainAll(winningNumbers.toSet())
    println("\nOs números que você acertou: $inputNumbers")

    when {
        inputNumbers.containsAll(winningNumbers) -> println("\nAs chances de você acertar eram de 1 em 13 milhões. " +
                "Eu tenho CERTEZA que você TRAPACEOU!!")
        else -> println("\nMensagem do sistema: HAHAA perdeste novamente!")
    }
}