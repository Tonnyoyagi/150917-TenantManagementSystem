# Tenant Management System

An Android Studio project for the Navigation Practical 1 lab. It uses beginner-level Kotlin, XML layouts, and the explicit and implicit Intents required by the practical.

## Open in Android Studio

Open Android Studio, choose **Open**, and select this project folder. Allow Gradle sync to finish, then select an emulator or connected Android phone and press **Run**.

The project uses Android Gradle Plugin 8.11.1, Gradle 8.13, Kotlin 2.2.20, and Java 17. Android Studio may download Gradle and Android dependencies during sync.

## Included flows

- Login is the launcher screen. Non-empty credentials open Add Tenant.
- Register returns the entered email to Login using an explicit Intent extra.
- Login opens the Strathmore website with `ACTION_VIEW`.
- Add Tenant checks that its fields are filled, displays the saved tenant summary, and opens the phone dialer with `ACTION_DIAL`.

Login and registration are demonstration screens; credentials are not stored or authenticated against an account database.
