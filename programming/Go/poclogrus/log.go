package szaqallogrus

import (
	log "github.com/sirupsen/logrus"
)

func UseLog() {
	log.WithFields(log.Fields{
		"animal": "walrus",
	}).Info("A walrus appears")
}
