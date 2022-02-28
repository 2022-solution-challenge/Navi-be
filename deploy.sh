
if [ $# -eq 0 ]; then
  echo "usage: $0 commit message"
  exit 1
fi

git add .
git commit -m "$1"
git push

gcloud builds submit --tag asia.gcr.io/solution-challenge-342001/solution-challenge
gcloud run deploy solution-challenge --image asia.gcr.io/solution-challenge-342001/solution-challenge --region=asia-northeast3