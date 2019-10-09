package main

import (
	"fmt"
	"net/http"
	"strings"
)

const (
	SUCCESS       = 0
	RETRY         = 1
	NOT_RETRIABLE = 2
)

type ApiStatusCode struct {
	httpStatuses []int
}

func NewApiStatusCode(statuses []int) *ApiStatusCode {
	apiStatus := ApiStatusCode{httpStatuses: statuses}
	return &apiStatus
}

func (s *ApiStatusCode) evaluate(httpStatus int) bool {
	for _, value := range s.httpStatuses {
		if value == httpStatus {
			return true
		}
	}
	return false
}

var (
	successful = NewApiStatusCode([]int{http.StatusAccepted, http.StatusOK, http.StatusCreated})
	retriable  = NewApiStatusCode([]int{http.StatusBadGateway, http.StatusRequestTimeout, http.StatusRequestTimeout, http.StatusBadRequest, http.StatusNotFound, http.StatusInternalServerError})
)

func resolveStatus(response *http.Response) {
	if successful.evaluate(response.StatusCode) {
		fmt.Print("Request successful")
	} else if retriable.evaluate(response.StatusCode) {
		fmt.Print("Retriable")
	} else {
		fmt.Println("Give up")
	}

}

func main() {
	reader := strings.NewReader("RequestBody")
	resp, err := http.Post("http://test.pl", "application/json", reader)
	if err != nil {
		fmt.Print(err.Error())
	}
	resolveStatus(resp)
}
