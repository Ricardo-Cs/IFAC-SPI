<?php
require_once "IObserver.php";

class SmsNotifier implements IObserver {
    public function update(string $status): void {
        echo "SMS enviado: Pedido $status\n";
    }
}
