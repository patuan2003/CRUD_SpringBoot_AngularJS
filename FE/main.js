const app = angular.module('myModule', []);

app.controller('myController', function ($scope, $http) {
    $scope.listSV = [];
    $scope.viTriUpdate = -1;
    $scope.request = {
        id: 0,
        ten: '',
        tuoi: 0,
        gioiTinh: false,
        chuyenNganh: 'ptpm'
    }
    const url = "http://localhost:8080/api/sinh-vien/";
    const api = url + 'hien-thi';
    hienThi();
    function hienThi() {
        $http.get(api).then(function (response) {
            $scope.listSV = response.data;
        })
    }

    $scope.removeSinhVien = function (event, index) {
        event.preventDefault();
        let sv = $scope.listSV[index];
        console.log(sv.id);
        $http.delete(url + 'remove/' + sv.id).then(function () {
            $scope.listSV.splice(index, 1);
            alert('Xóa thành công');
        })
    }

    $scope.detailSinhVien = function (event, index) {
        event.preventDefault();
        let sv = $scope.listSV[index];
        $scope.request.ten = sv.ten;
        $scope.request.tuoi = sv.tuoi;
        $scope.request.gioiTinh = sv.gioiTinh;
        $scope.request.chuyenNganh = sv.chuyenNganh;

        $scope.viTriUpdate = index;
    }

    $scope.updateSinhVien = function (event) {
        event.preventDefault();
        let sv = $scope.listSV[$scope.viTriUpdate];
        console.log(sv.id);
        if ($scope.viTriUpdate == -1) {
            alert('Chọn dòng cần xóa');
            return;
        } else {
            $http.put(url + 'update/' + sv.id, JSON.stringify($scope.request)).then(function () {
                alert('update thành công');
                hienThi();
            })
        }
    }

    $scope.saveSinhVien = function (event) {
        event.preventDefault();
        $http.post(url + 'save', JSON.stringify($scope.request)).then(function () {
            alert('thêm thành công');
            hienThi();
        })
    }
})