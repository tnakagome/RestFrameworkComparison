require 'sinatra'

set :port, 5000

post '/hello' do
  request.body.rewind
  data = JSON.parse request.body.read
  "Hello #{data['name']}!"
end
