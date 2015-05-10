describe('SongPlaysController', function () {

    var $controller, $httpBackend, $scope;

    beforeEach(module('app'));

    beforeEach(inject(function ($injector) {
        $controller = $injector.get('$controller');
        $httpBackend = $injector.get('$httpBackend');
        $scope = $injector.get('$rootScope').$new();
    }));
}