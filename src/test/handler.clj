(ns test.handler
  (:require [compojure.core :refer :all]
            [compojure.handler :as handler]
            [compojure.route :as route]))

(defroutes app-routes
  (GET "/" [] "<form action='/calculate'>
  						<input name='number'>
  						<input type='submit' value='Guess!'>
  						</form>")

	(GET "/calculate" [number]
				; this is the first function that checks if the the string is a number  string
				; if  condition is true do this
					(str "Your guess " number " is "
						(if (integer? (read-string number))
							(cond
								(> (Integer/parseInt number) 15) "too high!"
								(< (Integer/parseInt number) 15) "too low!"
								:else "correct!")
							"invalid")

							"</form>
							<form action='/calculate'>
	  						<input name='number'>
	  						<input type='submit' value='Guess!'>
	  						</form>"
		) ;end str
	) ;end GET
  (route/resources "/")
  (route/not-found "Not Found"))

(def app
  (handler/site app-routes))
