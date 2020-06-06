#!/usr/local/bin/perl

use Mojolicious::Lite;

post '/hello' => sub {
    my $c = shift;
    my $hash = $c->req->json;
    $c->render(text => 'Hello ' . $hash->{name}, format=>'txt');
};

app->start;
