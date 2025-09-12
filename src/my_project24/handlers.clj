(ns my-project24.handlers
  (:require [my-project24.views :as views]
            [reitit-extras.core :as reitit-extras]
            [ring.util.response :as response]))

(defn default-handler
  [error-text status-code]
  (fn [_]
    (-> (views/error-page error-text)
        (reitit-extras/render-html)
        (response/status status-code))))

(defn home-handler
  [{router :reitit.core/router
    :as request}]
  (-> {:user (:identity request)
       :router router}
      (views/home-page)
      (reitit-extras/render-html)))
