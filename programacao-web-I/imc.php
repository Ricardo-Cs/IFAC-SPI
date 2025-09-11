<?php

$altura = $_POST['altura'];
$peso = $_POST['peso'];
$imc = $peso/($altura**2);
$imc = number_format($imc, 2);

switch ($imc){
    case ($imc < 18.5);
    echo "Magreza. Seu imc é: $imc";
    break;
    case ($imc >= 18.5 && $imc <= 24.9);
    echo "Normal. Seu imc é: $imc";
    break;
    case ($imc >= 25.0 && $imc <= 29.9);
    echo "Sobrepeso. Seu imc é $imc";
    break;
    case ($imc >= 30.0 && $imc <= 34.9);
    echo "Obesidade. Seu imc é $imc";
    break;
    case ($imc > 34.9);
    echo "Obesidade Grave. Seu imc é $imc";
    break;
}