(function() {
   window.parent = {
     postMessage: function() {
        window.postMessage(...arguments);
     }
   };
   function messageHandler(e) {
     const type = e.data.type;
     if (type === 'score') {
       const data = e.data.scoreData;
       const rightNum = data.detail.resultDetail.rightNum;
       const totalNum = data.detail.resultDetail.questionSum;
       const rightRate = getRightRate(rightNum, totalNum);
       const answerPics = data.detail.resultDetail.answerPics;
       const judge = data.judge;
       const blobData = [];
       answerPics.forEach(item => {
         blobData.push(dataURLtoBlob(item));
       });
       const submitData = {
         userAnswer: answerPics,
         userAnswerResult: judge,
         rightRate,
         blobData
       };
       window.JsInjectionActivity.jsCallClient(
         JSON.stringify({
           className: 'HWClassCourseware',
           methodName: 'jsCallNativeCommon',
           params: { type: 'submitData', data: submitData }
         })
       );
     }
   }

   function getRightRate(rightNum, totalSum) {
     return Math.round((rightNum / totalSum) * 100);
   }
   function dataURLtoBlob(dataUrl) {
     if (!dataUrl) return;
     const arr = dataUrl.split(',');
     const mime = arr[0].match(/:(.*?);/)[1];
     let bstr = atob(arr[1]);
     let n = bstr.length;
     let u8arr = new Uint8Array(n);
     while (n--) {
       u8arr[n] = bstr.charCodeAt(n);
     }
     return new Blob([u8arr], { type: mime });
   }
   window.addEventListener('message', messageHandler);
 })();