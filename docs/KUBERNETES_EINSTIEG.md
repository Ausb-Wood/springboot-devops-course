# Kubernetes-Einstieg mit minikube

## Ziel

Die Teilnehmenden sollen verstehen, dass Kubernetes nicht einfach "Docker nochmal" ist.
Kubernetes verwaltet einen gewuenschten Zustand: Wie viele Pods sollen laufen, welches Image, welcher Port, welcher Service?

## Start

```bash
minikube start --driver=docker --cpus=2 --memory=4096
kubectl get nodes
```

## Image in minikube bauen

```bash
eval $(minikube docker-env)
docker build -t springboot-devops-course:local .
```

## Anwendung deployen

```bash
kubectl apply -f k8s/
kubectl get pods -n devops-kurs
kubectl get services -n devops-kurs
minikube service springboot-app -n devops-kurs --url
```

## Fehleranalyse

```bash
kubectl describe pod -n devops-kurs <POD-NAME>
kubectl logs -n devops-kurs deployment/springboot-app
```

## Aufraeumen

```bash
kubectl delete -f k8s/
minikube stop
```
