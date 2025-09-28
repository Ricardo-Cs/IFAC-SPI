<?php
$frase = $_POST["frase"] ?? "";
$palavra = $_POST["palavra"] ?? "";

if (strpos($frase, $palavra) !== false) {
    echo "A palavra existe na frase.";
} else {
    echo "A palavra NÃO existe na frase.";
}
