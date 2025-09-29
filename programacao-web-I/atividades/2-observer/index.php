<?php
require_once "Pedido.php";
require_once "EmailNotifier.php";
require_once "SmsNotifier.php";

$pedido = new Pedido();
$pedido->attach(new EmailNotifier());
$pedido->attach(new SmsNotifier());

$pedido->setStatus("Confirmado");
$pedido->setStatus("Enviado");
