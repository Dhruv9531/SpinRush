package com.spinrush.game

import android.app.Activity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import kotlin.random.Random

class MainActivity : Activity() {

    private var coins = 0
    private var spins = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val coinView = findViewById<TextView>(R.id.coins)
        val result = findViewById<TextView>(R.id.result)
        val spin = findViewById<Button>(R.id.spin)
        val mission = findViewById<Button>(R.id.mission)

        fun refresh() {
            coinView.text = "🪙 Coins: $coins"
        }

        spin.setOnClickListener {
            spins++

            val rewards = listOf(5, 10, 15, 25, 50, 100)
            val reward = rewards[Random.nextInt(rewards.size)]

            coins += reward
            result.text = "🎉 You won $reward coins!"
            refresh()
        }

        mission.setOnClickListener {
            if (spins >= 5) {
                coins += 50
                spins = 0
                result.text = "🔥 Daily mission complete! +50 coins"
                refresh()
            } else {
                result.text =
                    "Complete ${5 - spins} more spins for +50 coins."
            }
        }
    }
}
