(ns athens.views.publishing
  (:require
    ["@material-ui/icons/ArrowBack" :default ArrowBack]
    ["@material-ui/icons/Close" :default Close]
    ["@material-ui/icons/FolderOpen" :default FolderOpen]
    [athens.electron :as electron]
    [athens.subs]
    #_[athens.util :as util]
    [athens.views.buttons :refer [button]]
    [athens.views.modal :refer [modal-style]]
    [komponentit.modal :as modal]
    [re-frame.core :refer [subscribe dispatch]]
    [reagent.core :as r]
    [stylefy.core :as stylefy :refer [use-style]]))


(def modal-contents-style
  {:display "flex"
   :padding "1.5rem"
   :flex-direction "column"
   :align-items "center"
   :width "400px"
   ::stylefy/manual [[:p {:max-width "24rem"
                          :text-align "center"}]
                     [:button {:font-size "18px"}]]})


(defn window
  "If loading is true, then that means the user has opened the modal and the db was not found on the filesystem.
  If loading is false, do not allow user to exit modal, and show slightly different UI."
  []
  (fn []
      [:div (use-style modal-style)
       [modal/modal
        {:title    [:div.modal__title
                    [:h4 "Publishing"]
                    ;; (when-not @loading
                    ;;   [button {:on-click close-modal} [:> Close]])
                    ]
         ;; :on-close close-modal
         }]]))
