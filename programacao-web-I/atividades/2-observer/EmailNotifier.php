<?php
require_once "IObserver.php";

class EmailNotifier implements Observer {
    public function update(string $status): void {
        echo "📧 Email enviado: Pedido $status\n";
    }
}
