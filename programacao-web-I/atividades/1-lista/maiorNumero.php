<?php

$num1 = $_POST['num1'];
$num2 = $_POST['num2'];
$num3 = $_POST['num3'];
$num4 = $_POST['num4'];

echo "Maior valor: " . max($num1, $num2, $num3, $num4);