# Taco Cloud – Spring Boot Lernprojekt

Dieses Projekt ist mein erstes Spring-Boot-Projekt zum Lernen und Ausprobieren der grundlegenden Konzepte rund um Spring, Spring MVC und Datenbankanbindung.

Die Anwendung orientiert sich an dem Beispielprojekt **Taco Cloud** aus dem Buch **Spring in Action, Sixth Edition** von Craig Walls. Ziel ist nicht, eine fertige Produktiv-App zu bauen, sondern Schritt für Schritt zu verstehen, wie eine typische Spring-Boot-Webanwendung aufgebaut ist.

## Worum geht es?

In der App kann man einfache Taco-Bestellungen zusammenstellen. Dabei werden verschiedene Zutaten ausgewählt, einem Taco hinzugefügt und anschließend als Bestellung gespeichert.

Das Projekt dient vor allem dazu, folgende Themen praktisch zu üben:

- Spring Boot Grundstruktur
- Controller mit Spring MVC
- Thymeleaf Templates
- Formulare und Validierung
- Session-Attribute
- JDBC und Spring Data JDBC
- Repository-Pattern
- Mapping von Java-Klassen auf Datenbanktabellen
- H2-Datenbank zum lokalen Testen

## Aktueller Lernstand

Das Projekt befindet sich noch im Aufbau. Ich nutze es, um meinen Fortschritt beim Lernen von Spring Boot zu dokumentieren und verschiedene Konzepte praktisch nachzuvollziehen.

Bisher umgesetzt bzw. geübt:

- Anzeige eines Taco-Design-Formulars
- Auswahl von Zutaten
- Verarbeitung von Formularen
- Speichern von Bestellungen
- Verwendung von Spring Data JDBC
- Mapping von Entities mit `@Table`, `@Column`, `@Id` und `@MappedCollection`
- einfache Validierung von Eingaben

## Verwendete Technologien

- Java
- Spring Boot
- Spring MVC
- Spring Data JDBC
- Thymeleaf
- H2 Database
- Maven
- Lombok

## Projekt starten

Das Projekt kann lokal über Maven gestartet werden:

```bash
./mvnw spring-boot:run
```
Danach ist die Anwendung standardmäßig erreichbar unter:
http://localhost:8080
