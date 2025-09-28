<?php
require_once __DIR__ . '/IObserver.php';

class User implements Observer {
    private string $name;

    public function __construct(string $name) {
        $this->name = $name;
    }

    public function update(string $news): void {
        echo "{$this->name} recebeu: {$news}</br>";
    }
}
