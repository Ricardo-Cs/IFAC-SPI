<?php
require_once "IObserver.php";

class EmailNotifier implements IObserver {
    public function update(string $status): void {
        echo "Email enviado: Pedido $status</br>";
    }
}
