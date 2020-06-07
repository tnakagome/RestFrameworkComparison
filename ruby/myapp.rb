require 'sinatra'

post '/hello' do
  request.body.rewind
  data = JSON.parse request.body.read
  "Hello #{data['name']}!"
end
