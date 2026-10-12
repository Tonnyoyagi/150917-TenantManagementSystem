# Tenant Management System

An Android Studio project that starts with the Lesson 6 Tenant Management practical and continues into Navigation Practicals 1 and 2. It uses Kotlin, XML layouts, View Binding, Data Binding, Activities, Intents, Activity lifecycle callbacks, Fragments, a Navigation Graph, and the tenant data model.

## Open in Android Studio

Open Android Studio, choose **Open**, and select this project folder. Allow Gradle sync to finish, then select an emulator or connected Android phone and press **Run**.

The project uses Android Gradle Plugin 8.11.1, Gradle 8.13, Kotlin 2.2.20, and Java 17. Android Studio may download Gradle and Android dependencies during sync.

## Included flows

- Add Tenant is the starting screen from Lesson 6. `MainActivity` uses View Binding to access its controls and passes a `Tenant` object to the data-bound result TextView.
- Login is the launcher screen. Non-empty credentials open Add Tenant.
- Register returns the entered email to Login using an explicit Intent extra.
- Login opens the Strathmore website with `ACTION_VIEW`.
- Add Tenant checks that its fields are filled, displays the saved tenant summary, and opens the phone dialer with `ACTION_DIAL`.
- MainActivity logs its lifecycle to Logcat and saves/restores the last tenant when the screen rotates.
- The Dashboard, Add Tenant, and View Tenants fragments, shared in-memory tenant repository, and Navigation Graph are prepared for Practical 3. They are intentionally not hosted by MainActivity yet, as the lab specifies.

Login and registration are demonstration screens; credentials are not stored or authenticated against an account database.
