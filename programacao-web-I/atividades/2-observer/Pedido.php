<?php
require_once "IObserver.php";

class Pedido {
    private array $observers = [];
    private string $status;

    public function attach(IObserver $observer): void {
        $this->observers[] = $observer;
    }

    public function detach(IObserver $observer): void {
        $this->observers = array_filter(
            $this->observers,
            fn($obs) => $obs !== $observer
        );
    }

    public function setStatus(string $status): void {
        $this->status = $status;
        $this->notify();
    }

    private function notify(): void {
        foreach ($this->observers as $observer) {
            $observer->update($this->status);
        }
    }
}
