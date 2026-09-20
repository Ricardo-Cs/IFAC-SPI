<?php
interface IObserver {
    public function update(string $status): void;
}
