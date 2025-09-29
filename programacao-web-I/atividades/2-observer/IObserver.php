<?php
interface Observer {
    public function update(string $status): void;
}
