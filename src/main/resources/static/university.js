angular.module('university', ['ngStorage']).controller('UniversityController',
        function ($rootScope, $scope, $localStorage, $http) {

    const contextPath = 'http://localhost:9999/university/api/v1'
    $scope.loadStudents = function() {
        $http({
            url: contextPath + "/students",
            method: 'GET'
        }).then(function(response) {
            $scope.students = response.data;
        });
    };

    $scope.deleteStudent = function(id) {
        $http.delete(contextPath + "/students/" + id)
            .then(function() {
                $scope.loadStudents()
            });
    };

    $scope.addStudent = function() {
        $http.post(contextPath + "/students", $scope.newStudent)
            .then(function(response) {
                $scope.loadStudents();
            });
    };

    $scope.updateStudent = function() {
        $http.put(contextPath + "/students", $scope.updatedStudent)
            .then(function() {
                $scope.loadStudents();
            });
    };

    $scope.loadStudents();
});