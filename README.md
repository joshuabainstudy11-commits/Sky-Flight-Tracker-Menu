# SkyTrack Flight Training Tracker

A Java console application built to track flight training hours, academic progress, and readiness status for PPL (Private Pilot License) and CPL (Commercial Pilot License) students.

## Key Features
- **Student Registration & Management:** Full input validation for student details, contact numbers, and scores.
- **Flight & Theory Tracking:** Update logged hours and theory scores dynamically.
- **Progress Reports:** Calculates Readiness Status and Flight Readiness Indicators (CRI).

## Object-Oriented Design (OOP) Principles
- **Abstraction & Inheritance:** Abstract `Student` class serves as a base blueprint for `PPLStudent` and `CPLStudent`.
- **Interfaces:** `ProgressTracker` interface enforces implementation of assessment rules.
- **Polymorphism:** Demonstrates dynamic runtime behavior and method overloading.
- **Encapsulation:** Private attributes managed safely through validated getters and setters.

## Tech Stack
- **Language:** Java
- **IDE:** Apache NetBeans
