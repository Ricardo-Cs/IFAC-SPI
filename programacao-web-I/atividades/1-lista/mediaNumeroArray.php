<?php

$numeros = [];
$media = 0;

for ($i = 0; $i < 50; $i++) {
    $numeroAleatorio = rand(0, 100);
    array_push($numeros, $numeroAleatorio);
    $media += $numeroAleatorio;
}

var_dump($numeros);
echo "<br> <br> Média dos valores: " . $media / count($numeros);
