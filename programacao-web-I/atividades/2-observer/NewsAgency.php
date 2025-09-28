<?php
require_once __DIR__ . '/IObserver.php';

class NewsAgency {
    private array $observers = [];
    private string $news = "";

    public function subscribe(Observer $observer): void {
        $this->observers[] = $observer;
    }

    public function setNews(string $news): void {
        $this->news = $news;
        $this->notify();
    }

    private function notify(): void {
        foreach ($this->observers as $observer) {
            $observer->update($this->news);
        }
    }
}
