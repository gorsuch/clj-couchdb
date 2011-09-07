(ns clj-couchdb.core
	(:require [clj-http.client :as client]
		      [clj-json.core :as json]))

(defn fetch [base db id & [params]]
	(json/parse-string (:body (client/get (str base "/" db "/" id) {:basic-auth [(:auth-user params) (:auth-pass params)]}))))

(defn insert [base db doc & [params]]
	(client/post (str base "/" db) {:body (json/generate-string doc)
		                            :basic-auth [(:auth-user params) (:auth-pass params)]
		                            :content-type :json
		                            :accept :json}))

(defn view [base db design-doc name & [params]]
	(json/parse-string (:body (client/get (str base "/" db "/_design/" design-doc "/_view/" name) {:basic-auth [(:auth-user params) (:auth-pass params)]}))))