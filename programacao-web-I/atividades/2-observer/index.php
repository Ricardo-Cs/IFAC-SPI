<?php
require_once __DIR__ . '/User.php';
require_once __DIR__ . '/NewsAgency.php';

$agency = new NewsAgency();
$u1 = new User("Ricardo");
$u2 = new User("Maria");

$agency->subscribe($u1);
$agency->subscribe($u2);

$agency->setNews("Novo jogo lançado!");
