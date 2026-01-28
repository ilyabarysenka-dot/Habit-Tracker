# Habit Tracker — Android Project

This repository contains an Android project created to explore modern Android development in depth.  
The project focuses on architecture, modularization, and real-world features rather than being a minimal demo.

The application is a habit tracker that demonstrates how to build a scalable Android app using:

- Jetpack Compose
- Multi-module architecture
- Dependency Injection (Hilt)
- Offline-first data handling
- Feature-owned navigation

---

## 🎯 Project goals

- Practice building a real application from scratch
- Explore multi-module project structure
- Learn how features interact through clean boundaries
- Experiment with modern Android APIs and libraries
- Serve as a reference project for future Android development

---

## 🧩 Modularization

[📄 Architecture diagram](docs/modulization.png)

---

## 🧱 Core modules

### :core:common

Shared, platform-independent utilities used throughout the project.  
This module avoids Android-specific APIs and acts as a foundation for the codebase.

**Typical content:**
- Result and error wrappers
- Logging abstractions
- String providers
- Common exceptions
- Coroutine helpers and utilities

Because this module is pure Kotlin, it can be reused across different layers without introducing Android dependencies.

---

### :core:ui

Design system module that centralizes UI building blocks.

**Typical content:**
- Application theme
- Color palettes and typography
- Reusable Compose UI components
- Common UI states and helpers

Feature modules consume this module to build screens without duplicating UI logic.

---

### :core:model

Defines core domain models shared across layers.

**Typical content:**
- Entities
- Value objects
- Sealed models used across features and data

This module has no UI or framework dependencies.

---

### :core:navigation

Provides navigation infrastructure, not destinations.

**Key responsibilities:**
- Abstract `Navigator`
- Navigation back stack handling
- Entry provider mechanism for feature-owned navigation

Features contribute navigation entries using an installer abstraction.

---

### :core:network

Encapsulates network-related infrastructure.

**Typical content:**
- HTTP client setup
- API service definitions
- Network interceptors
- Serialization configuration

By isolating networking concerns, the rest of the app remains independent of specific implementations.

---

### :core:database

Local persistence infrastructure.

**Typical content:**
- Room database setup
- DAOs
- Database entities
- Migrations

This module exposes database access through clean APIs and does not depend on UI or feature modules.

---

### :core:notification

Notification-related infrastructure.

**Typical content:**
- Notification channel definitions
- Notification builders
- Scheduling helpers for reminders
- Abstractions for local notifications

Features can trigger notifications without dealing with low-level Android APIs.

---

### :core:data

Responsible for data access and coordination.

**Typical content:**
- Repository interfaces and implementations
- Integration with `:core:network`
- Integration with `:core:database`
- Data mappers

---

## 🧩 Feature modules

### :feature:<feature-name>

Each feature is a **self-contained vertical slice** and is split into submodules.

---

### :feature:<feature-name>:api

Public contract of the feature.

**Contains:**
- `NavKey` definitions
- Extensions on `Navigator` encapsulating feature navigation
- Public models or callbacks (if needed)

This ensures navigation logic does not leak across modules.

---

### :feature:<feature-name>:impl

Feature implementation.

**Contains:**
- ViewModels
- Compose screens
- Feature-specific logic
- Navigation entry contributions

**Each feature:**
- Owns its destinations
- Defines how it is navigated to
- Remains independent from other features

---

## 📱 App module

### :app

The entry point of the application.

**Responsibilities:**
- Application and activity setup
- App-level navigation composition
- Dependency injection setup
- Startup and initialization logic

Most high-level configuration happens here, while actual functionality lives in core, data, and feature modules.
