#pragma once

#include <drogon/HttpController.h>

using namespace drogon;

class GreetingController : public drogon::HttpController<GreetingController>
{
  public:
    METHOD_LIST_BEGIN
    ADD_METHOD_TO(GreetingController::post, "/hello", Post);
    ADD_METHOD_TO(GreetingController::get, "/hi/{1}", Get);
    METHOD_LIST_END

    void post(const HttpRequestPtr& req, std::function<void (const HttpResponsePtr &)> &&callback);
    void get(const HttpRequestPtr& req, std::function<void (const HttpResponsePtr &)> &&callback, std::string name);

  private:
    void reply(std::function<void (const HttpResponsePtr &)> &callback, std::string name);
};
