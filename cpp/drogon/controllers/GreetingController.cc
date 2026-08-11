#include "GreetingController.h"

void GreetingController::post(const HttpRequestPtr& req, std::function<void (const HttpResponsePtr &)> &&callback) {
    auto json = req->getJsonObject();
    auto name = (*json)["name"].asString();
    reply(callback, name);
}

void GreetingController::get(const HttpRequestPtr& req, std::function<void (const HttpResponsePtr &)> &&callback, std::string name) {
    reply(callback, name);
}

void GreetingController::reply(std::function<void (const HttpResponsePtr &)> &callback, std::string name) {
    auto resp = HttpResponse::newHttpResponse();
    resp->setStatusCode(k200OK);
    resp->setContentTypeCode(CT_TEXT_PLAIN);
    resp->setBody("Hello " + name + "!");
    callback(resp);
}