<?php

$numeros = [];

for ($i=0; $i < 50; $i++) { 
    $numeroAleatorio = rand(0, 100);
    array_push($numeros, $numeroAleatorio);
}

var_dump($numeros);
echo "<br> <br> Maior valor: " . max($numeros);