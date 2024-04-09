# Rapport sur le code de la Team Rocket

## Introduction

La team rocket nous à donné un code pour la PokemonFactory, nous allons donc l'analyser et voir s'il a des problèmes.

## Problèmes

- La langue

Malgrès le fait que le TP soit entièrement en français, ainsi que les données fournis dans les tps sont en français,
la team rocket a mit la liste des pokemons en anglais ce qui l'empêche de passer les tests qui sont prévus pour du français.

- Les indexs

Les index des pokemons sont décalés comparés à ceux fournis dans les tp, on nous donne bulbizarre qui est à l'index 0 mais dans ce code bulbizarre est à l'index 1 et Missingno à l'index 0.
Cela fait donc rater les tests car le mauvais pokemon est renvoyé.

- Le random

La metadata des pokemons créés dans la PokemonFactory sont créées aléatoirement ce qui va donc empêcher les tests de passer car les stats du pokemon sont mal initialisées.

- Les IV

Il n'y a pas de calcul d'iv (nous non plus mais bon, techniquement il faudrait)

- Le pikachu de sasha

Ce n'est pas un pokemon à part entière.

- Gestion d'exceptions

Au lieu de gérer les pokemons hors de la map, le pokemon missingno est renvoyé alors qu'il faudrait lancer une exception.

- La javadoc

Le code n'as pas de javadoc ce qui impacte le résultat final du checkstyle