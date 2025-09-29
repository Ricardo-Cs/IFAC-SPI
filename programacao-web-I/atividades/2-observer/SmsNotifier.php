<?php
require_once "IObserver.php";

class SmsNotifier implements Observer {
    public function update(string $status): void {
        echo "📱 SMS enviado: Pedido $status\n";
    }
}
