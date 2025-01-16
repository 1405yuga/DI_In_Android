package com.example.workmanager

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.biometric.BiometricManager
import androidx.biometric.BiometricPrompt
import androidx.core.content.ContextCompat
import androidx.work.Constraints
import androidx.work.Data
import androidx.work.NetworkType
import androidx.work.OneTimeWorkRequest
import androidx.work.WorkManager
import com.example.workmanager.databinding.ActivityMainBinding
import com.google.firebase.messaging.FirebaseMessaging
import java.util.concurrent.Executor

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    val TAG = this.javaClass.simpleName

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.workManagerButton.setOnClickListener { performWork() }
        binding.notificationButton.setOnClickListener { createAndShowNotification() }
        binding.pushNotificationButton.setOnClickListener { getFCMTokenForTesting() }
        binding.biometricButton.setOnClickListener { createBiometrics() }
    }

    private fun createBiometrics() {
        // check if authentication is available and confirmed
        val biometricManager = BiometricManager.from(this)
        when (biometricManager.canAuthenticate(BiometricManager.Authenticators.BIOMETRIC_STRONG or BiometricManager.Authenticators.DEVICE_CREDENTIAL)) {
            BiometricManager.BIOMETRIC_SUCCESS -> {
                showBiometricPrompt()
            }

            BiometricManager.BIOMETRIC_ERROR_NO_HARDWARE -> {
                Toast.makeText(this, "No biometric hardware available", Toast.LENGTH_SHORT).show()
            }

            BiometricManager.BIOMETRIC_ERROR_HW_UNAVAILABLE -> {
                Toast.makeText(this, "Biometric hardware is unavailable", Toast.LENGTH_SHORT).show()
            }

            BiometricManager.BIOMETRIC_ERROR_NONE_ENROLLED -> {
                Toast.makeText(this, "No biometric credentials enrolled", Toast.LENGTH_SHORT).show()
            }

            else -> {
                Toast.makeText(this, "Biometric authentication not supported", Toast.LENGTH_SHORT)
                    .show()
            }
        }
    }

    private fun showBiometricPrompt() {
        // use main thread as executor
        val executor: Executor = ContextCompat.getMainExecutor(this)

        //create biometric instance
        val biometricPrompt =
            BiometricPrompt(this, executor, object : BiometricPrompt.AuthenticationCallback() {
                override fun onAuthenticationError(errorCode: Int, errString: CharSequence) {
                    super.onAuthenticationError(errorCode, errString)
                    Toast.makeText(
                        this@MainActivity,
                        "Authentication error: $errString",
                        Toast.LENGTH_LONG
                    )
                        .show()
                }

                override fun onAuthenticationSucceeded(result: BiometricPrompt.AuthenticationResult) {
                    super.onAuthenticationSucceeded(result)
                    Toast.makeText(
                        this@MainActivity,
                        "Authentication successful !",
                        Toast.LENGTH_LONG
                    )
                        .show()
                }

                override fun onAuthenticationFailed() {
                    super.onAuthenticationFailed()
                    Toast.makeText(this@MainActivity, "Authentication failed !", Toast.LENGTH_LONG)
                        .show()
                }
            })

        //configure the prompt with title,subtitle and fallback
        val promptInfo = BiometricPrompt.PromptInfo.Builder()
            .setTitle("Authenticate with biometrics")
            .setSubtitle("Use fingerprint or face to authenticate")
            .setAllowedAuthenticators(BiometricManager.Authenticators.BIOMETRIC_STRONG or BiometricManager.Authenticators.DEVICE_CREDENTIAL)
            .build()

        biometricPrompt.authenticate(promptInfo)
    }

    private fun getFCMTokenForTesting() {
        FirebaseMessaging.getInstance().token.addOnCompleteListener { task ->
            Log.d(
                TAG, if (task.isSuccessful) "FCM token : ${task.result}"
                else "FCM token generation failed"
            )
        }
    }

    private fun createAndShowNotification() {
        val notificationHelper = NotificationHelper(this)
        notificationHelper.createNotificationChannel()
        notificationHelper.showNotification("Test title", "Hi , new notification here!")
        Log.d(TAG, "Notification shown!")
    }

    private fun performWork() {
//        prepare Input
        val someInput = Data.Builder().putString("INPUT_KEY", "Hello there!").build()
//        define constraints
        val constraints = Constraints.Builder().setRequiresCharging(true)
            .setRequiredNetworkType(NetworkType.CONNECTED).build()
//        create request
        val workerRequest = OneTimeWorkRequest.Builder(MyWorker::class.java).setInputData(someInput)
            .setConstraints(constraints).build()

        //enqueue the work
        WorkManager.getInstance(context = this).enqueue(workerRequest)
    }
}