#!/usr/local/bin/perl

use Mojolicious::Lite;

post '/hello' => sub {
    my $c = shift;
    my $hash = $c->req->json;
    $c->render(text => 'Hello ' . $hash->{name}, format=>'txt');
};

my $port   = 55555;
my $daemon = Mojo::Server::Daemon->new(
  app    => app,
  listen => ["http://*:$port"]
);
$daemon->run;

